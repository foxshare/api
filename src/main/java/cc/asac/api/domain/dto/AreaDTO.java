package cc.asac.api.domain.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: fox
 * Email:fayfoxcat@gmail.com
 * Date: 2020/6/22 13:24
 * Description(api): 用户对应实体类
 **/

@Data
@ApiModel("地区查询DTO")
@NoArgsConstructor
public class AreaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer pCode;

    private String pName;

    private Integer cCode;

    private String cName;

    private Integer cuCode;

    private String cuName;

}
