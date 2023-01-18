package com.catchmind.catchtable.controller.api;

import com.catchmind.catchtable.controller.CrudController;
import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.network.Header;
import com.catchmind.catchtable.domain.network.request.ProfileRequest;
import com.catchmind.catchtable.domain.network.response.ProfileResponse;
import com.catchmind.catchtable.service.ProfileLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")    // http://localhost:8888/api/
@RequiredArgsConstructor
public class ProfileApiController extends CrudController<ProfileRequest, ProfileResponse, Profile> {
    private final ProfileLogicService profileLogicService;

    @Override
    @PostMapping("")
    public Header<ProfileResponse> create(@RequestBody Header<ProfileRequest> request) {
        return null;
    }
    @Override
    public Header<ProfileResponse> read(Long id) {
        return null;
    }

    @Override
    @PutMapping("/re_password")
    public Header<ProfileResponse> update(@RequestBody Header<ProfileRequest> request) {
        return null;
    }

    @Override
    public Header<ProfileResponse> delete(Long id) {
        return super.delete(id);
    }

    @PostMapping("/login")
    public Header<ProfileResponse> login(@RequestBody Header<ProfileRequest> request){
        return profileLogicService.login(request);
    }

}
