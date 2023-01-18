package com.catchmind.catchtable.service;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.network.Header;
import com.catchmind.catchtable.domain.network.request.ProfileRequest;
import com.catchmind.catchtable.domain.network.response.ProfileResponse;
import com.catchmind.catchtable.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileLogicService extends BaseService<ProfileRequest, ProfileResponse, Profile> {
    private final ProfileRepository profileRepository;

    private ProfileResponse response(Profile profile){
        ProfileResponse profileResponse = ProfileResponse.builder()
                .prIdx(profile.getPrIdx())
                .prNick(profile.getPrNick())
                .prName(profile.getPrName())
                .prIntro(profile.getPrIntro())
                .prRegion(profile.getPrRegion())
                .prHp(profile.getPrHp())
                .prUserpw(profile.getPrUserpw())
                .prGender(profile.getPrGender())
                .prBirth(profile.getPrBirth())
                .prMemo(profile.getPrMemo())
                .regDate(profile.getRegDate())
                .updateDate(profile.getUpdateDate())
                .prReview(profile.getPrReview())
                .prNoshow(profile.getPrNoshow())
                .prBlock(profile.isPrBlock())
                .build();
        return profileResponse;
    }

    @Override
    public Header<ProfileResponse> create(Header<ProfileRequest> request) {
//        ResAdminApiRequest resAdminApiRequest = request.getData();
//
//        ResAdmin resAdmin = ResAdmin.builder().meUserid(adminUserApiRequest.getMeUserid())
//                .meUserpw(adminUserApiRequest.getMeUserpw())
//                .meName(adminUserApiRequest.getMeName())
//                .meHp(adminUserApiRequest.getMeHp())
//                .meName(adminUserApiRequest.getMeName())
//                .meEmail(adminUserApiRequest.getMeEmail())
//                .mePosition(adminUserApiRequest.getMePosition())
//                .build();
//        AdminUser newUsers = baseRepository.save(users);
//        return Header.OK(response(newUsers));
        return null;
    }

    @Override
    public Header<ProfileResponse> read(Long id) {
        return null;
    }

    public Header<ProfileResponse> read(String prHp, String prUserpw) {
        return profileRepository.findByPrHpAndPrUserpw(prHp, prUserpw).map(
                        users -> response(users)).map(Header::OK)
                .orElseGet(()->Header.ERROR("아이디또는 비번이 틀림")
                );
    }

    @Override
    public Header<ProfileResponse> update(Header<ProfileRequest> request) {
        return null;
    }

    @Override
    public Header<ProfileResponse> delete(Long id) {
        return null;
    }

    public Header<ProfileResponse> login(Header<ProfileRequest> request){
        ProfileRequest profileRequest = request.getData();

        Optional<Profile> profile = profileRepository.findByPrHpAndPrUserpw(profileRequest.getPrHp(),profileRequest.getPrUserpw());
        if(!profile.isEmpty()){
            return Header.Ok();
        }

        return Header.ERROR("아이디 또는 비밀번호가 틀렸음!");
    }
}
