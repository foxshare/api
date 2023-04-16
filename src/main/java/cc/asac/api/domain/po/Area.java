package cc.asac.api.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@TableName("t_area")
@ApiModel("地区实体类")
@NoArgsConstructor
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "")
    private Integer pCode;

    @ApiModelProperty(value = "")
    private String pName;

    @ApiModelProperty(value = "")
    private Integer cCode;

    @ApiModelProperty(value = "")
    private String cName;

    @ApiModelProperty(value = "")
    private Integer cuCode;

    @ApiModelProperty(value = "")
    private String cuName;

}
