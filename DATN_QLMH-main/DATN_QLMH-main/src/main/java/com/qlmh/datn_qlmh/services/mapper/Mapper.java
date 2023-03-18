package com.qlmh.datn_qlmh.services.mapper;

import com.qlmh.datn_qlmh.dtos.request.*;
import com.qlmh.datn_qlmh.dtos.response.CategoriesResp;
import com.qlmh.datn_qlmh.dtos.response.ImageResp;
import com.qlmh.datn_qlmh.dtos.response.ManufacturerResp;
import com.qlmh.datn_qlmh.dtos.response.ProductResp;
import com.qlmh.datn_qlmh.dtos.response.RateRes;
import com.qlmh.datn_qlmh.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    private final ModelMapper mapper;

    public Mapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public VoucherReq toVoucherReq(VoucherEntity voucherEntity) {
        return mapper.map(voucherEntity, VoucherReq.class);
    }

    public DiscountWithBillReq toDiscountWithBillReq(DiscountWithBillEntity discountWithBillEntity) {
        return mapper.map(discountWithBillEntity, DiscountWithBillReq.class);
    }

    public DiscountReq toDiscountReq(DiscountEntity discountEntity) {
        return mapper.map(discountEntity, DiscountReq.class);
    }

    public DiscountEntity toDiscountEntity(DiscountReq discountEntity) {
        return mapper.map(discountEntity, DiscountEntity.class);
    }
    public DiscountWithBillEntity toDiscountWithBillEntity(DiscountWithBillReq discountWithBillReq){
        return mapper.map(discountWithBillReq, DiscountWithBillEntity.class);
    }

    public VoucherEntity toVoucherEntity(VoucherReq voucherReq) {
        return mapper.map(voucherReq, VoucherEntity.class);
    }

    public ReturnReq toReturnReq(ReturnFigureEntity returnFigureEntity) {
        return mapper.map(returnFigureEntity, ReturnReq.class);
    }

    public ReturnFigureEntity toReturnFigureEntity(ReturnReq returnReq){
            return mapper.map(returnReq, ReturnFigureEntity.class);
        }
    public RateEntity toRateEntity(RateReq rateReq) {
        return mapper.map(rateReq, RateEntity.class);
    }

    public RateRes toRateRes(RateEntity rateEntity) {
        return mapper.map(rateEntity, RateRes.class);
    }

    public RateImgReq toRateImgReq(RateImgEntity rateImgEntity) {
        return mapper.map(rateImgEntity, RateImgReq.class);
    }

    public RateImgEntity toRateImgEntity(RateImgReq rateImgReq) {
        return mapper.map(rateImgReq, RateImgEntity.class);
    }

    public ProductRateEntity toProductRateEntity(ProductRateReq productRateReq) {
        return mapper.map(productRateReq, ProductRateEntity.class);
    }

    public ProductRateReq toProductRateReq(ProductRateEntity rateEntity) {
        return mapper.map(rateEntity, ProductRateReq.class);
    }

    public RequestExchangeProductReq toRequestExchangeProductReq(RequestExchangeProductEntity exchangeProductEntity){
        return mapper.map(exchangeProductEntity, RequestExchangeProductReq.class);
    }

    public RequestExchangeProductEntity toRequestExchangeProductEntity(RequestExchangeProductReq requestExchangeProductReq){
        return mapper.map(requestExchangeProductReq, RequestExchangeProductEntity.class);
    }

    public RequestExchangeProductDetailReq toRequestExchangeProductDetailReq(RequestExchangeProductDetailEntity requestExchangeProductDetailEntity){
        return mapper.map(requestExchangeProductDetailEntity, RequestExchangeProductDetailReq.class);
    }
    public RequestExchangeProductDetailEntity toRequestExchangeProductDetailEntity(RequestExchangeProductDetailReq requestExchangeProductDetailReq){
        return mapper.map(requestExchangeProductDetailReq,RequestExchangeProductDetailEntity.class);
    }

    public  ExchangeProductEntity toExchangeProductEntity(ExchangeProductReq exchangeProductReq){
        return mapper.map(exchangeProductReq, ExchangeProductEntity.class);
    }
    public ExchangeProductReq toExchangeProductReq(ExchangeProductEntity exchangeProductEntity){
        return mapper.map(exchangeProductEntity, ExchangeProductReq.class);
    }

    public ExchangeProductImgReq toExchangeProductImgReq(EchangeProductImgEntity echangeProductImgEntity ){
        return mapper.map(echangeProductImgEntity,ExchangeProductImgReq.class);
    }
    public EchangeProductImgEntity toEchangeProductImg(ExchangeProductImgReq exchangeProductImgReq){
        return mapper.map(exchangeProductImgReq,EchangeProductImgEntity.class);
    }



    public CategoriesEntity toCategoriesEntity(CategoriesReq categoriesReq) {
        return mapper.map(categoriesReq, CategoriesEntity.class);
    }

    public CategoriesReq toCategoriesReq(CategoriesEntity CategoriesEntity) {
        return mapper.map(CategoriesEntity, CategoriesReq.class);
    }
    public CategoriesResp toCategoriesResp(CategoriesEntity categoriesEntity) {
        return mapper.map(categoriesEntity, CategoriesResp.class);
    }

    public ManufacturerReq toManufacturerReq(ManufacturerEntity ManufacturerEntity) {
        return mapper.map(ManufacturerEntity, ManufacturerReq.class);
    }
    public ManufacturerResp toManufacturerResp(ManufacturerEntity ManufacturerEntity) {
        return mapper.map(ManufacturerEntity, ManufacturerResp.class);
    }

    public ManufacturerEntity toManufacturerEntity(ManufacturerReq manufacturerReq) {
        return mapper.map(manufacturerReq, ManufacturerEntity.class);
    }

    public ProductReq toProductReq(ProductEntity ProductEntity) {
        return mapper.map(ProductEntity, ProductReq.class);
    }

    public ProductEntity toProductEntity(ProductReq productReq) {
        return mapper.map(productReq, ProductEntity.class);
    }

    public ProductResp toProductResp(ProductEntity ProductEntity) {
        return mapper.map(ProductEntity, ProductResp.class);
    }


    public ImageEntity toImageEntity(ImageReq imageReq) {
        return mapper.map(imageReq, ImageEntity.class);
    }

    public ImageReq toImageReq(ImageEntity ImageEntity) {
        return mapper.map(ImageEntity, ImageReq.class);
    }

    public ImageResp toImageResp(ImageEntity ImageEntity) {

        return mapper.map(ImageEntity, ImageResp.class);
    }
    public VoucherAccountReq toVoucherAccountReq(VoucherAccountEntity voucherAccountEntity){
        return mapper.map(voucherAccountEntity, VoucherAccountReq.class);
    }
    public VoucherAccountEntity toVoucherAccountEntity(VoucherAccountReq voucherAccountReq){
        return mapper.map(voucherAccountReq, VoucherAccountEntity.class);
    }
    public AccountDto toAccountDto(AccountEntity accountEntity){
        return mapper.map(accountEntity, AccountDto.class);}
    public BlackListReq toBlackListReq(BlackListEntity blackListEntity){
        return mapper.map(blackListEntity, BlackListReq.class);
    }
    public BlackListEntity toBlackListEntity(BlackListReq blackListReq){
        return mapper.map(blackListReq, BlackListEntity.class);
    }
}
