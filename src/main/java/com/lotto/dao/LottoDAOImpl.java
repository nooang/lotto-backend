package com.lotto.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lotto.vo.LottoScoreVO;
import com.lotto.vo.LottoSearchVO;
import com.lotto.vo.LottoSequencedVO;
import com.lotto.vo.LottoSortVO;
import com.lotto.vo.LottoVO;

@Repository
public class LottoDAOImpl extends SqlSessionDaoSupport implements LottoDAO {
	
	@Autowired
	@Override
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}
	
	@Override
	public int insertLottoData(LottoVO lottoVO) {
		return getSqlSession().insert("insertLottoData", lottoVO);
	}

	@Override
	public int getNumCount(int num) {
		return getSqlSession().selectOne("getNumCount", num);
	}
	
	@Override
	public List<LottoVO> getAllNumber(LottoSearchVO lottoSearchVO) {
		return getSqlSession().selectList("getAllNumber", lottoSearchVO);
	}
	
	@Override
	public int getMaxRound() {
		return getSqlSession().selectOne("getMaxRound");
	}
	
	@Override
	public LottoVO getDrwtNoByRound(int round) {
		return getSqlSession().selectOne("getDrwtNoByRound", round);
	}
	
	@Override
	public LottoVO getMaxTotSellamnt() {
		return getSqlSession().selectOne("getMaxTotSellamnt");
	}
	
	@Override
	public LottoVO getMaxFirstWinamnt() {
		return getSqlSession().selectOne("getMaxFirstWinamnt");
	}
	
	@Override
	public LottoVO getMaxFirstAccumamnt() {
		return getSqlSession().selectOne("getMaxFirstAccumamnt");
	}
	
	@Override
	public LottoVO getMaxFirstPrzwnerCo() {
		return getSqlSession().selectOne("getMaxFirstPrzwnerCo");
	}
	
	@Override
	public List<LottoVO> getPrizeInfo(LottoSortVO lottoSortVO) {
		return getSqlSession().selectList("getPrizeInfo", lottoSortVO);
	}
	
	@Override
	public List<LottoScoreVO> getLottoScoreList(Map<String, Object> numbers) {
		return getSqlSession().selectList("getLottoScoreList", numbers);
	}
	
	@Override
	public LottoVO getLottoInfoByDrwNo(int drwNo) {
		return getSqlSession().selectOne("getLottoInfoByDrwNo", drwNo);
	}
	
	@Override
	public List<LottoVO> getDrwNoByDrwtNo(int drwtNo) {
		return getSqlSession().selectList("getDrwNoByDrwtNo", drwtNo);
	}
	
	@Override
	public List<LottoVO> getEvenAndOddCount(LottoVO lottoVO) {
		return getSqlSession().selectList("getEvenAndOddCount", lottoVO);
	}
	
	@Override
	public List<LottoSequencedVO> getSequencedDrwNo(int drwtNo) {
		return getSqlSession().selectList("getSequencedDrwNo", drwtNo);
	}
	
	@Override
	public List<LottoVO> getNotEmerged(LottoVO lottoVO) {
		return getSqlSession().selectList("getNotEmerged", lottoVO);
	}
}
