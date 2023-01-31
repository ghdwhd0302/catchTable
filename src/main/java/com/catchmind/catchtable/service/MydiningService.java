package com.catchmind.catchtable.service;

import com.catchmind.catchtable.domain.Reserve;
import com.catchmind.catchtable.domain.type.ReservationType;
import com.catchmind.catchtable.dto.ReserveDto;
import com.catchmind.catchtable.dto.ReviewDto;

import com.catchmind.catchtable.dto.network.ReviewRequest;
import com.catchmind.catchtable.repository.ReserveRepository;
import com.catchmind.catchtable.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

@Slf4j  // 로그를 찍기 위해서 사용하는 어노테이션
@Transactional
@RequiredArgsConstructor
@Service
public class MydiningService {
    private final ReserveRepository reserveRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public ReserveDto getDetail(Long resIdx) {
        return reserveRepository.findById(resIdx).map(ReserveDto::from)
                .orElseThrow();
    }

    @Transactional
    public void updateCancel(Long resIdx){
        Optional<Reserve> reserve = reserveRepository.findById(resIdx);
        reserve.ifPresent(
                newRes -> {
                    newRes.setResStatus(ReservationType.CANCEL);
                    reserveRepository.save(newRes);
                }
        );

    }

    public Long saveFile(MultipartFile files, ReviewRequest reviews) throws IOException {
        if (files.isEmpty()){
            return null;
        }
        ReviewRequest request = reviews;
        String origName = files.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String extension = origName.substring(origName.lastIndexOf("."));
        String savedName = uuid + extension;
        // 파일을 불러올 때 사용할 파일 경로
        String savedPath = "D:\\test/" + savedName;
        ReviewDto newReview = request.of(request.prIdx(),request.revContent(),request.revScore(),request.resaBisName(),origName,savedName,savedPath,request.resIdx()).toDto();
        files.transferTo(new File(savedPath));
        reviewRepository.save(newReview.toEntity());
        Optional<Reserve> reserve =  reserveRepository.findById(request.resIdx());
        reserve.ifPresent(
                newRes -> {
                    newRes.setRevStatus(true);
                    reserveRepository.save(newRes);
                }
        );
        return null;
    }
}
