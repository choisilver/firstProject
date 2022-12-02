package edu.web.jsp02.dto;

import edu.web.jsp02.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// 업데이트를 위한 정보를 전달 할 때 사용하는 객체. DTO(Data Transfer Object) -> Entity 클래스만 사용할 경우 DB에서 변경될 수 있음.

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class PostUpdateDto {
    
    private Integer id;
    private String title;
    private String content;
    
    public Post toEntity() {
        return Post.builder()
                .id(id).title(title).content(content)
                .build();
    }
    
    
}
