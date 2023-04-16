package cc.asac.api.dao;

import cc.asac.api.domain.dto.AreaDTO;
import cc.asac.api.domain.po.Area;
import cc.asac.api.domain.po.UserPO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fox
 * @since 2020-04-26
 */
@Repository
@Mapper
public interface AreaMapper extends BaseMapper<UserPO> {

    /**
     * 根据条件查询地区列表
     *
     * @param areaDTO 查询dto
     * @return 返回列表
     */
    List<Area> listByCondition(AreaDTO areaDTO);
}
