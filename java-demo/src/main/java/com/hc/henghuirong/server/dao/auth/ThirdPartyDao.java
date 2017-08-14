package com.hc.henghuirong.server.dao.auth;

import com.hc.henghuirong.server.common.model.auth.ThirdParty;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by Wu.Kang on 2017/3/30.
 */
public interface ThirdPartyDao extends Mapper<ThirdParty> {
    String FIELDS = "id,third_id as thirdId,`desc`,secret_key as secretKey,status,create_time as createTime";
    String deleteStatus = "2";
    /**
     * 增加一条第三方信息
     * @param
     * @return
     */
    @Insert("insert into third_party(third_id,`desc`,secret_key,status,create_time) values(#{thirdId},#{desc},#{secretKey},#{status},now())")
    int add(ThirdParty thirdParty);

    /**
     * 修改第三方状态
     * @return
     */
    @Update("update third_party set status=#{status} where id=#{id}")
    int updateStatus(@Param("id") Long id, @Param("status") Integer status);

    /**
     * 修改第三方秘钥
     * @return
     */
    @Update("update third_party set secret_key=#{secretKey} where id=#{id}")
    int updateKey(@Param("id") Long id, @Param("secretKey") String secretKey);

    /**
     * 修改第三方信息和秘钥
     * @return
     */
    @Update("update third_party set secret_key=#{secretKey},`desc`=#{desc} where id=#{id}")
    int updateKeyAndDesc(@Param("id") Long id, @Param("secretKey") String secretKey, @Param("desc") String desc);

    /**
     * 查询所有第三方记录
     * @return
     */
    @Select("select " + FIELDS + " from third_party where status <>" + deleteStatus + " limit 200")
    List<ThirdParty> getAll();

    /**
     * 根据id查询第三方记录
     * @return
     */
    @Select("select " + FIELDS + " from third_party where status <>" + deleteStatus + " and id=#{id}")
    ThirdParty getById(@Param("id") Long id);

    /**
     * 根据第三方id查询第三方记录
     * @return
     */
    @Select("select " + FIELDS + " from third_party where status <>" + deleteStatus + " and third_id=#{thirdId}")
    ThirdParty getByThirdId(@Param("thirdId") String thirdId);

}
