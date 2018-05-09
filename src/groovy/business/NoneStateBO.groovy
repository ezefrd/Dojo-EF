package business

import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@Builder
class NoneStateBO extends StateBO implements Serializable {

    private static final long serialVersionUID = 3131579081732411035L

    NoneStateBO(){
        id = null
        name = null
    }
}
