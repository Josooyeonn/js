package co.edu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO extends DAO {
	
	// id로 한건조회
	public Student searchStudent(String id) {
		conn = getConnect();
		String sql = "select * from student_info where student_no = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) { //rs.next() : 한 건 조회된 결과가 있으면
				
				Student stud = new Student();
				stud.setStudentNo(rs.getInt("student_no")); // rs.get~ : result set에 담겨 있는 값을 가지고 오기
				stud.setStudentName(rs.getString("student_name"));
				stud.setEngScore(rs.getInt("eng_score"));
				stud.setKorScore(rs.getInt("kor_score"));
				return stud;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return null; //조회했는데 결과 없을 때
	}
	
	// 수정
	public boolean modifyStudent(Student std) {
		conn = getConnect();
		String sql = "update student_info set student_name=?, eng_Score=?, kor_Score=? where student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, std.getStudentName());
			psmt.setInt(2, std.getEngScore());
			psmt.setInt(3, std.getKorScore());
			psmt.setInt(4, std.getStudentNo());

			int r = psmt.executeUpdate(); // 변경됐는지 안됐는지 참고하기위함
			System.out.println(r + "건 변경");
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 건수가 없거나 에러가 나면 false
		
	}

	// 한건삭제
	public boolean removeStudent(String id) {
		conn = getConnect();
		String sql = "delete from student_info where student_no=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			int r = psmt.executeUpdate(); // 삭제됐는지 안됐는지 참고하기위함
			System.out.println(r + "건 삭제");
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 건수가 없거나 에러가 나면 false

	}

	// 한건입력
	public boolean addStudent(Student stud) {
		conn = getConnect(); // Connection 객체를 가져옴
		String sql = "insert into student_info values(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, stud.getStudentNo());
			psmt.setString(2, stud.getStudentName());
			psmt.setInt(3, stud.getEngScore());
			psmt.setInt(4, stud.getKorScore());
			int r = psmt.executeUpdate(); // 얘가 실행이 돼야 실제로 업데이트가 됨
			System.out.println(r + "건 입력"); // 제대로 인서트되는지 확인하는 부분
			if (r > 0) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return false; // 에러 발생 혹은 정상적으로 처리 안됐을 떄
	}

	// 전체조회
	public List<Student> studentList() {

		// db에 있는 값을 가져와서 json 값을 만들려는 작업
		conn = getConnect();
		List<Student> list = new ArrayList<Student>();
		try {
			psmt = conn.prepareStatement("select * from student_info order by student_no");
			rs = psmt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNo(rs.getInt("student_no"));
				student.setStudentName(rs.getString("student_name"));
				student.setEngScore(rs.getInt("eng_score"));
				student.setKorScore(rs.getInt("kor_score"));
				list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
