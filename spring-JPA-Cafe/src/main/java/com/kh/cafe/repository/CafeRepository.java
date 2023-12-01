package com.kh.cafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kh.cafe.vo.Cafe;

public interface CafeRepository extends JpaRepository<Cafe,Long>{
	//카페가 존재하는지 존재 여부(boolean)
	boolean existByName(String name);
	
	//Count를 이용해서 지역의 갯수가 몇개인지 찾아보는 메서드
	int countByLocation(String location);
	
	//특정 문자열을 포함한 엔터티를 검색하는데 사용하는 메서드
	List<Cafe> findByNameContaining(String keyword);
	
	//@Query("SELECT c FROM Cafe c WHERE c.name LIKE %:keyword%")
		//1. 만약에 보여줄 것이 많다. => List로 담아서 한 번에 보여주자!
		//List<Cafe> findCafe(@Param("keyword") String keyword);
		
		//2. 보여줄 것이 하나 => Cafe 객체 하나만 호출할 것
}
/*

Query Creation : Spring Data JPA 에서 제공하는 기능
				 메서드에 규칙이 존재하고 규칙에 따라서 메서드를 생성해주는 기능
				 메서드 이름으로 데이터베이스 쿼리를 생성
				 					
				 					
				 SELECT					Name	FROM WHERE LIKE name = ? 
				 List<Cafe>	findBy		Name	Containing(String keyword);
				 List<모델>  실행명령어		컬럼명 	Containing(String 검색키워드);					
				 
				 
				 JPA 규칙을 지정해서 이 규칙만 지켜주면
				 내가 알아서 쿼리를 만들어줄게
				 
	findBy + 내가 적고싶은 변수명
	예를들어 Cafe 라는 Class 에 작성해놓은
		private String name;
		private String location;
		private String openingHours; 에서
		
		지역을 검색하고 싶다면
			findByLocation(String location)
			=> SELECT * FROM Cafe WHERE location = ?
			
				findByNameContaining(String keyword);
				Containing => 해당하는 변수명이 특정 변수에 대한 검색을
								Like로 진행할 수 있게 도와줌.
			
		운영시간을 검색하고 싶다면
			findByOpeningHours(String openingHours)
			=> SELECT * FROM Cafe WHERE openingHours = ?
			
		총 갯수를 계산해주는 메서드를 만들고 싶다면
			countBy 클래스에 적어준 변수명
			만약에 지역에 카페가 몇개 인지 궁금해
				countByLocation(String Location)
				=> SELECT COUNT(*) FROM Cafe WHERE location = ?		
				(어느 정도는 GROUP BY 나 ORDER BY 도 포함 되어있는데 직접 쿼리문을 작성해주는게 나을수 있음 )
				
		존재 여부를 확인해주는 메서드를 만들고 싶다면
			existsBy 클래스에 적어준 변수명
				existsByLocation(String Location)
				SELECT CASE WHEN COUNT(*) > 0 THEN true
											  ELSE false
					END FROM Cafe WHERE location = ?
					
		만약에 삭제하고 싶다면 
			deleteBy 클래스에 적어준 변수명
			deleteByLocation(String Location)
			DELETE FROM Cafe WHERE location =  ?
				
 
 Query -> AND OR Is Equals Between After Before Like OrderBy
 In False True IgnoreCase
  
  		
  		1. JPA에서 SQL AND 구문을 써야할 때
  			findBy변수명AND다른변수명
  			
  		2.JPA에서 SQL OR 구문을 써야할 때
  			findBy변수명OR다른변수명
  		
  		3.JPA에서 SQL IS 또는 Equals 구문을 써야할 때
  			findBy변수명IS
  			findBy변수명Equals
  			
  		4.JPA에서 SQL Between After Before Like 구문을 써야할 때
  			findBy변수명Between
  			findBy변수명After
  			findBy변수명Before
  			findBy변수명Like
  			
  		5.JPA에서 SQL OrderBy 구문을 써야할 때
  			findBy변수명OrderBy정렬하고자하는기준변수명DESC
  			findBy변수명OrderBy정렬하고자하는기준변수명ASC
  		
  		6. JPA에서 SQL In 구문을 써야할 때
  			findBy변수명In(List<예약어>변수명)
  			
  		
  		 7. JPA에서 SQL False True 구문을 써야할 때
  		 	findBy변수명False()
  		 		SQL : WHERE 테이블명의단축어.변수명(SQL테이블명)=false
  		 	findBy변수명True()
  		 		SQL : WHERE 테이블명의단축어.변수명(SQL테이블명)=true
  		 		
  		 
  		 8.JPA에서 SQL IgnoreCase 구문을 써야할 때
  		 	findBy변수명IgnoreCase
  		 	
  			
  
  
 * */
 