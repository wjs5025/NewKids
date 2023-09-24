package com.ssafy.keywordservice.api.controller.keyword;

import com.ssafy.keywordservice.api.controller.ApiResponse;
import com.ssafy.keywordservice.api.controller.keyword.request.CreatedKeywordRequest;
import com.ssafy.keywordservice.api.controller.keyword.response.KeywordResponse;
import com.ssafy.keywordservice.api.service.keyword.KeywordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/keyword-service/api")
public class KeywordController {

    private final KeywordService keywordService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<KeywordResponse> createKeyword(@RequestBody CreatedKeywordRequest request) {
        log.debug("call KeywordController#createKeyword");
        log.debug("request word={}", request.getWord());

        KeywordResponse response = keywordService.createKeyword(request.getWord());
        log.debug("response={}", response);

        return ApiResponse.created(response);
    }
}
