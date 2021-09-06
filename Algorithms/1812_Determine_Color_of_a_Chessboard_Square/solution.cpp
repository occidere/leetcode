class Solution {
public:
    bool squareIsWhite(string coordinates) {
        int x = (coordinates[0] - 'a') % 2;
        int y = (coordinates[1] - '0') % 2;
        return (x == 0 && y == 0) || (x == 1 && y == 1);
    }
};
