package test;

import static org.junit.Assume.assumeFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import config.DBManager;
import dto.MovieDTO;

class MovieTest {
	static SqlSession session;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//movie.json 파일 읽어옴
		
		FileReader fr = new FileReader("movie (1).json");
		BufferedReader br = new BufferedReader(fr);
		session = DBManager.getInstance().getTestSession();
		String str = "";
		while(true) {
			String t = br.readLine();
			if(t==null)break;
			str += t;
		}
		System.out.println(str);
		JSONArray arr = new JSONArray(str);
		SqlSession session = DBManager.getInstance().getTestSession();
		int count = 0;
		for(int i=0;i<arr.length();i++) {
			JSONObject obj = arr.getJSONObject(i);
			MovieDTO dto =new MovieDTO(obj.getInt("bno"),
					obj.getString("title"),
					obj.getString("open_date"),obj.getInt("audience_count"),
					obj.getString("director"));
			System.out.println(dto.toString());
			count += session.insert("insertTestMovie", dto);
		}
		System.out.println("테스트 데이터"+ count + "건 추가 하였습니다");
	
	//읽어온 내용을 movie 테이블에 추가
	}



	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.rollback();
		System.out.println("테스트 데이터 제거");
	}
	//데이터 추가 데이트 - insertMovie
	@Test
void testinsertMovie(){
	MovieDTO dto = new MovieDTO(9999,"테스트제목","23/09/11",123415,"감독");
	int result =  0;
	try {
		result = session.insert("insertMovie",dto);
	}catch (Exception e) {
		System.out.println(e.getMessage());
	}
			
	assertEquals(result,1,"영화 정보 추가가 기능 테스트 실패");
	}
	@Test
	void test(){
	}
     //데이터 검색 테이트 - selectMovieList
	void testSelectMovieList() {
		List<MovieDTO> list = session.selectList("selectMovieList", "닥터"); 
		assumeFalse(list.size() == 0,"영화 정보 검색 기능 테스트 실패");
		
		if(list.size() == 0)
			fail("영화 정보 검색 기능 테스트 실패");
	}

}
