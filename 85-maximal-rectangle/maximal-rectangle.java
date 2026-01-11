class Solution {

    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int largestArea = 0;
        int area, nse, pse;

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                int ind = st.pop();
                pse = st.isEmpty() ? -1 : st.peek();
                nse = i;
                area = heights[ind] * (nse - pse - 1);
                largestArea = Math.max(largestArea, area);
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            nse = n;
            int ind = st.pop();
            pse = st.isEmpty() ? -1 : st.peek();
            area = heights[ind] * (nse - pse - 1);
            largestArea = Math.max(largestArea, area);
        }

        return largestArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[j] = (matrix[i][j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
}
