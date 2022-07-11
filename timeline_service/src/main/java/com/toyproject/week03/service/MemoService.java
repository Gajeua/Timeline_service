package com.toyproject.week03.service;

import com.toyproject.week03.domain.Memo;
import com.toyproject.week03.domain.MemoRepository;
import com.toyproject.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {

    public final MemoRepository memoRepository;

    @Transactional
    public void update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
    }

}
