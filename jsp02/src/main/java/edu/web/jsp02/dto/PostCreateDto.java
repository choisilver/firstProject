package edu.web.jsp02.dto;

import edu.web.jsp02.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// VO(Value Object): 값(데이터) 저장하는 객체. DB의 테이블과 같은 구조로 설계. 컬럼개수, 타입 등을 동일 (예) Post
// DTO(Data Transfer Object): 계층들 사이에서 값(데이터)를 전달할 때 사용하는 객체.
//  controller(web) 계층layer과 service 계층(layer) 사이에서
//  메서드를 호출할 때 argument의 타입 또는 메서드의 리턴 타입으로 사용되는 객체. listener랑 비슷한가?
// 메서드 호출 아규먼트로 전달, 리턴타입 둘중 하나로 전달됨. VO만 사용하는 경우도 많음. 불필요한 데이터를 전달하지 않고 필요한 필드만 가진 것..!

@NoArgsConstructor // 기본생성자
@AllArgsConstructor // 모든 필드들을 argument로 갖는 생성자를 만듦.
@Builder // 내부클래스, 생성자, 메서드까지 다 만들어줌. Builder 패턴에서 필요한 내부클래스, 필드 등
@Data // getter, setter, equals, hashCode,...  @Getter, @Setter, @ToString, @@EqualsAndHashCode, @RequiredArgusConstructor

public class PostCreateDto {
    
    private String title;
    private String content;
    private String author;

    // PostCreateDto 타입을 Post 타입으로 변환해서 리턴하는 메서드
    public Post toEntity() {
        return Post.builder()
                .title(title).content(content).author(author)  
                .build();
        
    }

}



