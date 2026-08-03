package net.ada.v1_5_2.capability;

final class BlockPosKey {

    final int x;
    final int y;
    final int z;

    BlockPosKey(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BlockPosKey)) {
            return false;
        }
        BlockPosKey k = (BlockPosKey) o;
        return x == k.x && y == k.y && z == k.z;
    }

    @Override
    public int hashCode() {
        return (x * 31 + y) * 31 + z;
    }
}
