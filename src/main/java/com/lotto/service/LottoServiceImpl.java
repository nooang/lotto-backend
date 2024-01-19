package com.lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lotto.dao.LottoDAO;
import com.lotto.vo.LottoScoreVO;
import com.lotto.vo.LottoSearchVO;
import com.lotto.vo.LottoSequencedVO;
import com.lotto.vo.LottoSortVO;
import com.lotto.vo.LottoVO;

@Service
@Transactional
public class LottoServiceImpl implements LottoService {
	@Autowired
	private LottoDAO lottoDAO;
	
	@Override
	public boolean insertLottoData(LottoVO lottoVO) {
		return lottoDAO.insertLottoData(lottoVO) > 0;
	}

	@Override
	public int getNumCount(int num) {
		return lottoDAO.getNumCount(num);
	}
	
	@Override
	public List<LottoVO> getAllNumber(LottoSearchVO lottoSearchVO) {
		return lottoDAO.getAllNumber(lottoSearchVO);
	}
	
	@Override
	public int getMaxRound() {
		return lottoDAO.getMaxRound();
	}
	
	@Override
	public LottoVO getDrwtNoByRound(int round) {
		return lottoDAO.getDrwtNoByRound(round);
	}
	@Override
	public List<Map<String, Object>> getMaxAmnt() {
		Map<String,Object> totSellamntMap = new HashMap<>();
		Map<String,Object> firstWinamntMap = new HashMap<>();
		Map<String,Object> firstAccumamntMap = new HashMap<>();
		Map<String,Object> firstPrzwnerCoMap = new HashMap<>();
		LottoVO lottoVO_ = new LottoVO();
		
		lottoVO_ = lottoDAO.getMaxTotSellamnt();
		totSellamntMap.put("drwNo", lottoVO_.getDrwNo());
		totSellamntMap.put("totSellAmnt", lottoVO_.getTotSellamnt());
		
		lottoVO_ = lottoDAO.getMaxFirstWinamnt();
		firstWinamntMap.put("drwNo", lottoVO_.getDrwNo());
		firstWinamntMap.put("firstWinamnt", lottoVO_.getFirstWinamnt());
		
		lottoVO_ = lottoDAO.getMaxFirstAccumamnt();
		firstAccumamntMap.put("drwNo", lottoVO_.getDrwNo());
		firstAccumamntMap.put("firstAccumamnt", lottoVO_.getFirstAccumamnt());

		lottoVO_ = lottoDAO.getMaxFirstPrzwnerCo();
		firstPrzwnerCoMap.put("drwNo", lottoVO_.getDrwNo());
		firstPrzwnerCoMap.put("firstPrzwnerCo", lottoVO_.getFirstPrzwnerCo());
		
		List<Map<String, Object>> resultList = new ArrayList<>();
		resultList.add(totSellamntMap);
		resultList.add(firstWinamntMap);
		resultList.add(firstAccumamntMap);
		resultList.add(firstPrzwnerCoMap);
		
		return resultList;
	}
	
	@Override
	public List<LottoVO> getPrizeInfo(LottoSortVO lottoSortVO) {
		return lottoDAO.getPrizeInfo(lottoSortVO);
	}
	
	@Override
	public List<LottoScoreVO> getLottoScoreList(Map<String, Object> numbers) {
		return lottoDAO.getLottoScoreList(numbers);
	}
	
	@Override
	public LottoVO getLottoInfoByDrwNo(int drwNo) {
		return lottoDAO.getLottoInfoByDrwNo(drwNo);
	}
	
	@Override
	public List<LottoVO> getDrwNoByDrwtNo(int drwtNo) {
		return lottoDAO.getDrwNoByDrwtNo(drwtNo);
	}
	
	@Override
	public List<LottoVO> getEvenAndOddCount(LottoVO lottoVO) {
		return lottoDAO.getEvenAndOddCount(lottoVO);
	}
	
	@Override
	public List<LottoSequencedVO> getSequencedDrwNo(int drwtNo) {
		return lottoDAO.getSequencedDrwNo(drwtNo);
	}
	
	@Override
	public List<LottoVO> getNotEmerged(LottoVO lottoVO) {
		return lottoDAO.getNotEmerged(lottoVO);
	}
}
