package other

import groovy.transform.EqualsAndHashCode
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy

/**
 * Created by efridman on 7/5/18.
 */
@EqualsAndHashCode(includes = ['id'])
public class IdNameTuple {
    String id;
    String name;

    public IdNameTupleBuilder asBuilder() {
        return new IdNameTupleBuilder()
                .id(id)
                .name(name);
    }

    static IdNameTuple from(Map source, boolean capitalize = false) {
        if (!source) {
            return null
        }
        String name = source?.name
        String id = source?.id
        new IdNameTupleBuilder()
                .id(id)
                .name(capitalize ? name?.capitalize() : name)
                .build()
    }
}

@Builder(builderStrategy = ExternalStrategy, forClass = IdNameTuple)
public class IdNameTupleBuilder {}

