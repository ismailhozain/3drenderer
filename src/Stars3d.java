import javax.naming.InitialContext;

public class Stars3d {
    private final float m_spread;
    private final float m_speed;

    private final float m_starX[];
    private final float m_starY[];
    private final float m_starZ[];

    public Stars3d(int numStars, float spread, float speed) {
        m_speed = speed;
        m_spread = spread;
        m_starX = new float[numStars];
        m_starY = new float[numStars];
        m_starZ = new float[numStars];

        for(int i =0; i < m_starX.length; i++) {
            InitStar(i);
        }
    }
    private void InitStar(int i) {
        m_starX[i] = 2 * ((float) Math.random() - 0.5f) * m_spread;
        m_starY[i] = 2 * ((float) Math.random() - 0.5f) * m_spread;
        m_starZ[i] = ((float) Math.random() + 0.00001f) * m_spread;

    }
    public void UpdateAndRender(Bitmap target, float delta) {
        target.Clear((byte)0x00);

        float halfWidth = target.GetWidth()/2.0f;
        float halfHeight = target.GetHeight()/2.0f;
        for(int i =0; i < m_starX.length; i++) {
            m_starZ[i] -= delta * m_speed;
            if (m_starZ[i] <= 0) {
                InitStar(i);
            }
            int x = (int)(m_starX[i] * halfWidth + halfHeight);
            int y = (int)(m_starY[i] * halfWidth + halfHeight);

            if(x < 0 || x >= target.GetWidth() || (y < 0 || y >= target.GetHeight()))  {
                InitStar(i);
            }
            else {
                target.DrawPixel(x, y, (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF);
            }
        }
    }
}
