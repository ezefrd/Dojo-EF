package business

import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@Builder
class CityBO implements Serializable{

    private static final long serialVersionUID = 3466005695278892648L

    String id
    String name

    Map asMap() {
        return [id: id, name: name]
    }

}

