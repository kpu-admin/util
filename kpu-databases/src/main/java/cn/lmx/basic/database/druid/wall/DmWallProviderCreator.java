package cn.lmx.basic.database.druid.wall;

import com.alibaba.druid.DbType;
import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallProvider;
import com.alibaba.druid.wall.WallProviderCreator;
import com.alibaba.druid.wall.spi.OracleWallProvider;

/**
 *
 * @author lmx
 * @date 2025-01-01 00:00
 **/
public class DmWallProviderCreator implements WallProviderCreator {
    @Override
    public WallProvider createWallConfig(DataSourceProxy dataSource, WallConfig config, DbType dbType) {
        if (config == null) {
            config = new WallConfig(OracleWallProvider.DEFAULT_CONFIG_DIR);
        }

        return new OracleWallProvider(config);
    }
}
