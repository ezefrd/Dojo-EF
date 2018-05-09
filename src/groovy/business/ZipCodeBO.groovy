package business

import enums.DestinationType
import other.IdNameTuple

/**
 * Created by efridman on 7/5/18.
 */
class ZipCodeBO implements Serializable {
    String zipCode
    CityListBO cities
    NeighborhoodListBO neighborhoods
    StateListBO states
    IdNameTuple country
    IdNameTuple municipality
    //TODO: cambiar extendedAttributes, por atributos mas amigables a los BO, ejemplo status y LocationBO
    Map<String, Object> extendedAttributes = [:]
    LocationBO location
    boolean active

    Map obtainCityAsMap() {
        return getCity().asMap()
    }

    CityBO getCity() {
        cities.getIfThereIsOnlyOne()
    }

}