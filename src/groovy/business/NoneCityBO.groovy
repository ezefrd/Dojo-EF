package business

import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@Builder
class NoneCityBO extends CityBO{

    private static final long serialVersionUID = 1732941464304304562L


    NoneCityBO(){
        id = null
        name = null
    }

}
