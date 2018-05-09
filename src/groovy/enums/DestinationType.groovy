package enums

/**
 * Created by efridman on 7/5/18.
 */
public enum DestinationType implements Serializable {
    CITY('city'),
    ZIPCODE('zip_code'),
    ADDRESS('address')

    final String type

    public DestinationType(String _type) {
        this.type = _type
    }

    public static DestinationType from(String _type) {
        values().find{ it.type.equalsIgnoreCase(_type) }
    }

    public static boolean isValid(String name) {
        return DestinationType.find { it.name() == name }
    }

}