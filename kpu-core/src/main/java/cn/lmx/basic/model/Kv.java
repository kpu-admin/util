package cn.lmx.basic.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Objects;

/**
 * 键值对 通用对象
 *
 * @author lmx
 * @version v3.3.0
 * @date 2025-01-01 00:00
 */
@Data
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kv implements Serializable {
    private String key;
    private String value;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Kv kv = (Kv) o;
        return Objects.equals(key, kv.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
