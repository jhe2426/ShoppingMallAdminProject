package com.shopping.shopping.service.implement;

import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.shopping.shopping.common.constant.ResponseMessage;
import com.shopping.shopping.dto.request.PostProductRequestDto;
import com.shopping.shopping.dto.response.ResponseDto;
import com.shopping.shopping.entity.CategoryDetailEntity;
import com.shopping.shopping.entity.FavoriteEntity;
import com.shopping.shopping.entity.ProductEntity;
import com.shopping.shopping.repository.CategoryDetailRepository;
import com.shopping.shopping.repository.FavoriteRepository;
import com.shopping.shopping.repository.ProductRepository;
import com.shopping.shopping.service.ProductService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {


    private final AmazonS3Client amazonS3Client;
    private final CategoryDetailRepository categoryDetailRepository;
    private final ProductRepository productRepository;
    private final FavoriteRepository favoriteRepository;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


    @Override
    public ResponseEntity<ResponseDto> postProduct(PostProductRequestDto dto) {

        int categoryDetailNumber = dto.getCategoryDetailNumber();
        MultipartFile uploadImage = dto.getImage();
        String originalFileName = uploadImage.getOriginalFilename();
        String uploadFileName = buildFileName(originalFileName);
        
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(uploadImage.getContentType());
        metadata.setContentLength(uploadImage.getSize());
        try {
            amazonS3Client.putObject(bucket, uploadFileName, uploadImage.getInputStream(), metadata);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseMessage.FILE_UPLOAD_ERROR;
        }
        
        String s3ImageUrl =  amazonS3Client.getUrl(bucket, uploadFileName).toString();
        

        try {
            CategoryDetailEntity categoryDetailEntity = categoryDetailRepository.findByCategoryDetailNumber(categoryDetailNumber);
            ProductEntity productEntity = new ProductEntity(dto, categoryDetailEntity, s3ImageUrl);
            productRepository.save(productEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseMessage.DATABASE_ERROR;
        }
        
        return ResponseMessage.SUCCESS;
    }
    
    private String buildFileName(String originaslFileName) {
        String fileExtensionSeparator = ".";
        
        int fileExtensionIndex = originaslFileName.lastIndexOf(fileExtensionSeparator);
        String fileExtension = originaslFileName.substring(fileExtensionIndex);
        String fileName = UUID.randomUUID().toString();

        String uploadFileName =  fileName + fileExtension;

        return uploadFileName;
    }

    @Override
    public Page<ProductEntity> getProductList(Pageable pageable) {
        Page<ProductEntity> body = null;
        try {
            body = productRepository.findAll(pageable);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return body;
    }

    
    @Override
    @Transactional
    public ResponseEntity<ResponseDto> deleteProduct(int productNumber) {

        System.out.println(productNumber);

        try {
            ProductEntity productEntity = productRepository.findByProductNumber(productNumber);

            List<FavoriteEntity> favoriteList = favoriteRepository.findByProductEntity(productEntity);

            if(!(favoriteList == null)) {
                favoriteRepository.deleteAll(favoriteList);
            }

            productRepository.delete(productEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseMessage.DATABASE_ERROR;
        }
        
        return ResponseMessage.SUCCESS;
    }
}
