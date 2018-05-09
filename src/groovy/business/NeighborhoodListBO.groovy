package business

/**
 * Created by efridman on 7/5/18.
 */

class NeighborhoodListBO extends ArrayList<NeighborhoodBO> implements Serializable{

    private static final long serialVersionUID = 8047066061247957920L

    NeighborhoodBO getIfThereIsOnlyOne() {
        return this.size() == 1 ? this.first() : new NoneNeighborhoodBO()
    }
}
