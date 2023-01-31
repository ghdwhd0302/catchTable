package com.catchmind.catchtable.dto.network;

import com.catchmind.catchtable.dto.ProfileDto;
import com.catchmind.catchtable.dto.ResAdminDto;
import com.catchmind.catchtable.dto.ReserveDto;
import com.catchmind.catchtable.dto.ReviewDto;

public record ReviewRequest(
        Long prIdx,
        String revContent,
        double revScore,
        String resaBisName,
        String orgNm,
        String savedNm,
        String savedPath,
        Long resIdx
) {

    public ReviewRequest of(Long prIdx,
                            String revContent,
                            double revScore,
                            String resaBisName,
                            String orgNm,
                            String savedNm,
                            String savedPath,
                            Long resIdx) {
        return new ReviewRequest(prIdx,revContent,revScore,resaBisName,orgNm,savedNm,savedPath,resIdx);
    }

    public ReviewDto toDto() {
        return ReviewDto.of(ProfileDto.of(prIdx), revContent, revScore, ResAdminDto.of(resaBisName), orgNm, savedNm, savedPath, ReserveDto.of(resIdx));
    }
}
