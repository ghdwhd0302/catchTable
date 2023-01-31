package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.ResAdmin;
import com.catchmind.catchtable.domain.Reserve;
import com.catchmind.catchtable.domain.Review;

import java.time.LocalDateTime;

public record ReviewDto(
        Long revIdx,
        ProfileDto profileDto,
        Long revLike,
        String revContent,
        double revScore,
        ResAdminDto resAdminDto,
        String orgNm,
        String savedNm,
        String savedPath,
        LocalDateTime regDate,
        LocalDateTime updateDate,
        ReserveDto reserveDto

) {

    public static ReviewDto from(Review review) {
        return new ReviewDto(
                review.getId(),
                ProfileDto.from(review.getProfile()),
                review.getRevLike(),
                review.getRevContent(),
                review.getRevScore(),
                ResAdminDto.from(review.getResAdmin()),
                review.getOrgNm(),
                review.getSavedNm(),
                review.getSavedPath(),
                review.getRegDate(),
                review.getUpdateDate(),
                ReserveDto.from(review.getReserve())
        );
    }

    public static ReviewDto of(
            ProfileDto profileDto,
            String revContent,
            double revScore,
            ResAdminDto resAdminDto,
            String orgNm,
            String savedNm,
            String savedPath,
            ReserveDto reserveDto) {
        return new ReviewDto(0L, profileDto, 0L, revContent, revScore, resAdminDto, orgNm, savedNm, savedPath, null, null, reserveDto);
    }

    public Review toEntity() {
        return Review.of(
                profileDto.toEntity1(),
                revContent,
                revScore,
                resAdminDto.toEntity(),
                orgNm,
                savedNm,
                savedPath,
                reserveDto.toEntity()
        );

    }

}
