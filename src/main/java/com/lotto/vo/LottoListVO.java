package com.lotto.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LottoListVO {
	private int lottoCnt;
	private List<LottoVO> lottoList;
}
