package business

import enums.DestinationType
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@EqualsAndHashCode
@ToString
@Builder
class DestinationBO  implements Serializable, Cloneable{

    private static final long serialVersionUID = -2427527149183678489L


    DestinationType type //TODO: Utilizar DestinationType del proyecto
    String value
    Map<String, Map<String, String>> extraInfo = [:]

    public boolean isAddressType() {
        return DestinationType.ADDRESS == this.type
    }

    DestinationBO clone(){
        return builder().type(this.type).value(this.value).build()
    }
}
