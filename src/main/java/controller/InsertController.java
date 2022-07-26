package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.MovieDTO;
import service.MovieService;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		String title = request.getParameter("title");
		String openDate = request.getParameter("open_date");
		int audienceCount = Integer.parseInt(request.getParameter("audience_count"));
		String director = request.getParameter("director");
		
		int result = MovieService.getInstance().insertMovie(
				new MovieDTO(0, title, openDate, audienceCount, director));
		if(result == 0) throw new Exception();
		//System.out.println(result);
		//데이터 등록이 성공하면 전체 영화데이터를 json으로 전송
		List<MovieDTO> list = MovieService.getInstance().selectAllMovie();
		//System.out.println(list);
		JSONArray arr = new JSONArray(list);
		response.getWriter().write(arr.toString());
		//데이터 등록이 실패하면 데이터 등록에 실패 하였습니다. 에러 메세지 처리
		}catch (NumberFormatException e) {
			response.setStatus(1001);
			response.getWriter().write("누적 관객수는 숫자로 입력하세요");
		} catch (Exception e) {
			response.setStatus(1002);
			response.getWriter().write("데이터 등록에 실패 하였습니다.");
		}
	}

}




