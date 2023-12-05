package com.kh.springdb.service;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.kh.springdb.model.vo.Cart;
import com.kh.springdb.model.vo.Item;
import com.kh.springdb.repository.ItemRepository;

public class ItemService {

	private ItemRepository itemRepository;
	//상품을 추가하고 삭제하고 수정하는 기능
	@Autowired
	public ItemService() {
		this.itemRepository = itemRepository;
	}
	public void addItem(Item item, MultipartFile photoFile) throws IllegalStateException, IOException {//상품 추가
		//상품명 저장될 파일명 경로 생성
		//이미지 파일 정보에 대해 추출
		String originPhotoName = photoFile.getOriginalFilename();//업로드된 이미지파일의 원본파일명을 가져옴
		String photoName = "";
		String photoPath = System.getProperty("user.dir") + "src/main/resources/static/uploadImg/";//업로드 된 이미지 파일 경로 설정
		//System.getProperty("user.dir") 현재 코드가 작업하고있는 폴더 위치
		//"user.dir"=현재 작업하고 있는 사용자 폴더를 나타냄
		//user.dir은 //C:Users/user1/springBoot-workspace/JPA-ImgUpload-Cart-Order 이 위치와 동일함
		
		String saveFileName = "khShop_" + originPhotoName; //충돌을 막기위해 이름을 다시 설정해줌
		//saveFileName으로 만약에 판매자가 사진 1을 올리면 
		//내 폴더 안에는 khshop_사진1로 저장됨
		//빈 값에다가 한번 더 재정의로 넣어줌
		photoName = saveFileName;
		//import java.io.File
		//파일을 저장하기위해 우리가 작성해놓은 파일을 작성하기 위한 공간이 비어있는 File객체를 가지고 옴
		//						파일을 저장할 경로, 파일명
		File saveFile = new File(photoPath, photoName);
		
		//만약에 이름을 변경해서저장하고싶지않다면
		//originPhotoName으로 저장해도됨
		//판매자 컴퓨터에있는 이미지 이름 그대로 업로드됨
		photoFile.transferTo(saveFile);//업로드된 이미지  파일을 지정된 경로에 저장하기 위해 설정
		//transferTo 서버에 특정 경로에 저장할 수 있도록해주는 메서드
		item.setPhotoName(photoName);
		item.setPhotoPath("/img/"+photoName);
		
		itemRepository.save(item);//DB에 저장할 수 있도록 save
	}
	//상품읽기 find를 사용해서 개별 읽기
	public Item getItemById(Integer id) {
		return itemRepository.findById(id).get();//Optional을 사용하지 않는 방법 .get()
		//findById를 사용해서  Id에 해당하는 값을 가져오고 
		//get을 이용해서 Item의 객체를 반환
		
	}
	//모든 상품 가지고오기 List
	public List<Item> allItemList(){
		return itemRepository.findAll();
	}
	public void itemDelete(Integer Id) {
		itemRepository.deleteById(Id);
	}
	public void saveItem(Item item, MultipartFile imgFile) {
		// TODO Auto-generated method stub
		
	}
}
