package com.catchmind.catchtable.service;


import com.catchmind.catchtable.dto.ReviewDto;
import com.catchmind.catchtable.dto.ReviewPhotoDto;
import com.catchmind.catchtable.dto.network.response.IndexResponse;
import com.catchmind.catchtable.repository.ReviewPhotoRepository;
import com.catchmind.catchtable.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewLogicService {
    private final ReviewRepository reviewRepository;

    private final ReviewPhotoRepository reviewPhotoRepository;
    public List<ReviewDto> reviewList(String resaBisName){
        return reviewRepository.findAllByResAdmin_ResaBisName(resaBisName).stream().map(ReviewDto::from).toList();
    }

    public Page<ReviewDto> reviewList(String resaBisName, PageRequest pageRequest){
        Page<ReviewDto> reviewDtos = reviewRepository.findAllByResAdmin_ResaBisName(resaBisName,pageRequest).map(ReviewDto::from);
        return reviewDtos;
    }
    public Page<ReviewDto> reviewList(String resaBisName, Pageable pageable){
        Page<ReviewDto> reviewDtos = reviewRepository.findAllByResAdmin_ResaBisName(resaBisName,pageable).map(ReviewDto::from);
        return reviewDtos;
    }
    //가게 이름으로 찾은 리뷰정보가

    public List<ReviewDto> reviewList(){
        return reviewRepository.findAll().stream().map(ReviewDto::from).toList();
    }

    public List<IndexResponse> indexReviewList() {
        List<ReviewDto> reviewDtos = reviewRepository.findTop6By().stream().map(ReviewDto::from).toList();
        List<ReviewPhotoDto> photoDtos = reviewPhotoRepository.findAll().stream().map(ReviewPhotoDto::from).toList();
        List<IndexResponse> reviewList = new ArrayList<>();


        // 리뷰 별 사진 리스트
        for (int i = 0; i < reviewDtos.size(); i++) {
            List<ReviewPhotoDto> photoList = new ArrayList<>();
            for (int j = 0; j < photoDtos.size(); j++) {
                if (reviewDtos.get(i).revIdx() == photoDtos.get(j).reviewDto().revIdx()) {
                    String orgNm = photoDtos.get(j).orgNm();
                    String savedNm = photoDtos.get(j).savedNm();
                    String savedPath = photoDtos.get(j).savedPath();
                    ReviewDto reviewDto = photoDtos.get(j).reviewDto();
                    ReviewPhotoDto real = ReviewPhotoDto.of(orgNm, savedNm, savedPath, reviewDto);
                    photoList.add(real);
                }
            }
            if (photoList.isEmpty()) {
                IndexResponse response = new IndexResponse(reviewDtos.get(i).revIdx(), reviewDtos.get(i).profileDto(), reviewDtos.get(i).revContent(), reviewDtos.get(i).revScore(),
                        reviewDtos.get(i).resAdminDto(), null, reviewDtos.get(i).reserveDto());
                reviewList.add(response);
            } else {
                IndexResponse response = new IndexResponse(reviewDtos.get(i).revIdx(), reviewDtos.get(i).profileDto(), reviewDtos.get(i).revContent(), reviewDtos.get(i).revScore(),
                        reviewDtos.get(i).resAdminDto(), photoList, reviewDtos.get(i).reserveDto());
                reviewList.add(response);
            }
        }
        System.out.println("검증 후 리뷰 리스트 : " + reviewList);
        return reviewList;
    }

}
