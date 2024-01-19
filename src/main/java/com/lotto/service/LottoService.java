package com.lotto.service;

import java.util.List;
import java.util.Map;

import com.lotto.vo.LottoScoreVO;
import com.lotto.vo.LottoSearchVO;
import com.lotto.vo.LottoSequencedVO;
import com.lotto.vo.LottoSortVO;
import com.lotto.vo.LottoVO;

public interface LottoService {
	public boolean insertLottoData(LottoVO lottoVO);
	public int getNumCount(int num);
	public List<LottoVO> getAllNumber(LottoSearchVO lottoSearchVO);
	public int getMaxRound();
	public LottoVO getDrwtNoByRound(int round);
	public List<Map<String, Object>> getMaxAmnt();
	public List<LottoVO> getPrizeInfo(LottoSortVO lottoSortVO);
	public List<LottoScoreVO> getLottoScoreList(Map<String, Object> numbers);
	public LottoVO getLottoInfoByDrwNo(int drwNo);
	public List<LottoVO> getDrwNoByDrwtNo(int drwtNo);
	public List<LottoVO> getEvenAndOddCount(LottoVO lottoVO);
	public List<LottoSequencedVO> getSequencedDrwNo(int drwtNo);
	public List<LottoVO> getNotEmerged(LottoVO lottoVO);
}