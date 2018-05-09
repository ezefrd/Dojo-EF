package business

/**
 * Created by efridman on 7/5/18.
 */

class NeighborhoodBO implements Serializable {

    private static final long serialVersionUID = 6046427821149471257L

    String id
    String name

    Map asMap() {
        return [id: id, name: name]
    }

}
