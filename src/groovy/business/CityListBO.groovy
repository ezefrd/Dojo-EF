package business

/**
 * Created by efridman on 7/5/18.
 */
class CityListBO extends ArrayList<CityBO> implements Serializable{

    private static final long serialVersionUID = -121001773721761138L

    CityBO getCityById(String cityId){
        this.find {it.id == cityId}
    }

    CityBO getCityIfAbsentThen(String defaultCity){
        return this.find {CityBO cityBO -> cityBO.name?.equalsIgnoreCase(defaultCity) } ?: new CityBO(name: defaultCity)
    }

    CityBO getIfThereIsOnlyOne(){
        return this.size() == 1 ? this.first() : new NoneCityBO()
    }
}
