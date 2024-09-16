package com.example.productcatlog.Services;

import com.example.productcatlog.Dtos.FakeStoreProductDto;
import com.example.productcatlog.Dtos.ProductDto;
import com.example.productcatlog.Models.Category;
import com.example.productcatlog.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;



@Service
public class FakeStoreService implements IproductService{
    @Autowired
  private RestTemplateBuilder restTemplateBuilder;
    @Override
    public Product getProductById(Long id) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> fakeStoreProductDtoResponseEntity=restTemplate.getForEntity("https://fakestoreapi.com/products/{id}", FakeStoreProductDto.class, id);
        if(fakeStoreProductDtoResponseEntity.getStatusCode().is2xxSuccessful()&&fakeStoreProductDtoResponseEntity.getBody()!=null) {
            return getProduct(fakeStoreProductDtoResponseEntity.getBody());
        }
           return null;
    }

    @Override
    public Product createProduct(Product product) {

        FakeStoreProductDto input=getFakeStoreProductDto(product);
        FakeStoreProductDto fakeStoreProductDtoRespnse= requestForEntity("https://fakestoreapi.com/products",HttpMethod.POST,input,FakeStoreProductDto.class).getBody();
        return getProduct(fakeStoreProductDtoRespnse);
    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }

    @Override
    public Product ReplaceProduct(Product product, Long productId) {
        FakeStoreProductDto input=getFakeStoreProductDto(product);
     FakeStoreProductDto fakeStoreProductDtoResponse=  requestForEntity("https://fakestoreapi.com/products/{id}",HttpMethod.PUT,input,FakeStoreProductDto.class,productId).getBody();
     return getProduct(fakeStoreProductDtoResponse);
    }
        private <T> ResponseEntity<T> requestForEntity(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
            RestTemplate restTemplate=restTemplateBuilder.build();
            RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
            ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
            return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);}

 private FakeStoreProductDto getFakeStoreProductDto(Product product)
            {
                FakeStoreProductDto fakeStoreProductDto=new FakeStoreProductDto();
                fakeStoreProductDto.setId(product.getId());
                fakeStoreProductDto.setTitle(product.getName());
                fakeStoreProductDto.setImage(product.getImageUrl());
                fakeStoreProductDto.setDescription(product.getDescription());
                fakeStoreProductDto.setPrice(product.getPrice());
           if(product.getCategory()!=null)
                    fakeStoreProductDto.setCategory(product.getCategory().getName());

                return fakeStoreProductDto;
            }

    private Product getProduct(FakeStoreProductDto fakeStoreProductDto){

        Product product=new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setName(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        if(fakeStoreProductDto.getCategory()!=null){
        Category  category=new Category();
        category.setName(fakeStoreProductDto.getCategory());
        product.setCategory(category);}
  return product;
    }
}
