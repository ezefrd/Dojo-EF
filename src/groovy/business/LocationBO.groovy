package business

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.builder.Builder

/**
 * Created by efridman on 7/5/18.
 */
@EqualsAndHashCode
@ToString
@Builder
class LocationBO  implements Serializable, Cloneable{
    BigDecimal longitude
    BigDecimal latitude


    LocationBO clone(){
        return builder().longitude(this.longitude).latitude(this.latitude).build()
    }
}
