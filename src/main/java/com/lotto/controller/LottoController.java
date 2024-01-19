package com.lotto.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lotto.service.LottoService;
import com.lotto.vo.LottoScoreVO;
import com.lotto.vo.LottoSearchVO;
import com.lotto.vo.LottoSequencedVO;
import com.lotto.vo.LottoSortVO;
import com.lotto.vo.LottoVO;

@RestController
public class LottoController {
	@Autowired
	private LottoService lottoService;
	
	// 로또 회차 정보 입력
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/lotto/insert")
	public Map<String, Object> insertLottoData(@RequestBody LottoVO lottoVO) {
		Map<String, Object> resultSet = new HashMap<>();
		boolean isSuccess = lottoService.insertLottoData(lottoVO);
		
		if (isSuccess) {
			resultSet.put("result", "success");
		}
		else {
			resultSet.put("result", "fail");
		}
		
		return resultSet;
	}
	
	// 특정 번호의 등장횟수 조회
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/lotto/count/{num}")
	public Map<String, Object> getNumCount(@PathVariable int num) {
		
		Map<String, Object> resultSet = new HashMap<>();
		int count = lottoService.getNumCount(num);
		
		resultSet.put("result", "success");
		resultSet.put("count", count);
		
		return resultSet;
	}
	
	// 모든 회차의 모든 번호 조회
	@GetMapping("/lotto/all-number")
	public List<LottoVO> getAllNumber(@RequestParam(name = "drwLowNo", defaultValue = "0") String drwLowNo, 
									@RequestParam(name = "drwHighNo", defaultValue = "0") String drwHighNo) {
		LottoSearchVO lottoVO = new LottoSearchVO();
		lottoVO.setDrwLowNo(Integer.parseInt(drwLowNo));
		lottoVO.setDrwHighNo(Integer.parseInt(drwHighNo));
		
		return lottoService.getAllNumber(lottoVO);
	}
	
	// 마지막 회차 라운드 조회
	@GetMapping("/lotto/max-round")
	public int getMaxRound() {
		return lottoService.getMaxRound();
	}
	
	// 특정 회차의 당첨 번호
	@GetMapping("/lotto/drwt-no/{round}")
	public LottoVO getDrwtNoByRound(@PathVariable int round) {
		return lottoService.getDrwtNoByRound(round);
	}
	
	// 1등 당첨금, 1등 총 당첨금, 총 상금액의 최대값 조회
	@GetMapping("/lotto/max-amnt")
	public List<Map<String, Object>> getMaxAmnt() {
		return lottoService.getMaxAmnt();
	}
	
	// 역대 총 당첨금, 1등 당첨금 조회
	@PostMapping("/lotto/prize-info")
	public List<LottoVO> getPrizeInfo(@RequestBody LottoSortVO lottoSortVO) {
		System.out.println("getDrwNo...:" + lottoSortVO.getDrwNo());
		System.out.println("getTotSellamnt...:" + lottoSortVO.getTotSellamnt());
		System.out.println("getFirstWinamnt...:" + lottoSortVO.getFirstWinamnt());
		System.out.println("getFirstAccumamnt...:" + lottoSortVO.getFirstAccumamnt());
		return lottoService.getPrizeInfo(lottoSortVO);
	}
	
	@PostMapping("/lotto/score-list")
	public List<LottoScoreVO> getLottoScoreList(@RequestBody Map<String, Object> numberList) {
		List<LottoScoreVO> lottoScoreList = new ArrayList<>();
		
		lottoScoreList = lottoService.getLottoScoreList(numberList);
		return lottoScoreList;
	}
	
	@GetMapping("/lotto/info/{drwNo}")
	public LottoVO getLottoInfoByDrwNo(@PathVariable int drwNo) {
		return lottoService.getLottoInfoByDrwNo(drwNo);
	}
	
	@GetMapping("/lotto/drw-no-list/{drwtNo}")
	public List<LottoVO> getDrwNoByDrwtNo(@PathVariable int drwtNo) {
		return lottoService.getDrwNoByDrwtNo(drwtNo);
	}
	
	@PostMapping("/lotto/even-odd-cnt")
	public List<LottoVO> getEvenAndOddCount(@RequestBody LottoVO lottoVO) {
		return lottoService.getEvenAndOddCount(lottoVO);
	}
	
	@GetMapping("/lotto/sequence-drw-no/{drwtNo}")
	public List<LottoSequencedVO> getSequencedDrwNo(@PathVariable int drwtNo) {
		return lottoService.getSequencedDrwNo(drwtNo);
	}
	
	@PostMapping("/lotto/not-emerged")
	public List<LottoVO> getNotEmerged(@RequestBody LottoVO lottoVO) {
		return lottoService.getNotEmerged(lottoVO);
	}
}
