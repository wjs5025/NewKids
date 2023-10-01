package com.ssafy.vocabularyservice.api.service.vocabulary;

import com.ssafy.vocabularyservice.api.controller.vocabulary.response.VocabularyResponse;
import com.ssafy.vocabularyservice.api.controller.vocabulary.response.WordClientResponse;
import com.ssafy.vocabularyservice.domain.vocabulary.repository.VocabularyQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class VocabularyQueryService {

    private final VocabularyQueryRepository vocabularyQueryRepository;

    public Page<VocabularyResponse> getMyVocabulary(String memberKey, Pageable pageable) {
        List<VocabularyResponse> content = vocabularyQueryRepository.findByMemberKey(memberKey);

        long totalCount = vocabularyQueryRepository.getTotalCountByMemberKey(memberKey);

        return new PageImpl<>(content, pageable, totalCount);
    }

    public List<WordClientResponse> getMyVocabularyClient(String memberKey) {
        List<Long> ids = vocabularyQueryRepository.findIdClientByMemberKey(memberKey);
        if (ids.size() < 10) {
            return new ArrayList<>();
        }

        Collections.shuffle(ids);

        List<Long> options = ids.subList(0, 10);

        return vocabularyQueryRepository.findClientByMemberKey(options);
    }
}
