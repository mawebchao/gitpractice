import java.awt.image.BufferedImage;

public class Column extends GameObject{
    private int step;
    private int minYCut;
    private int column_type;
    public Column(int type,int cut){
        this.width=28;
        this.height=286;
        column_type=type;
        minYCut=cut;
        step=5;
        x=PlayingPanel.WIDTH;
        y=type==PlayingPanel.TOP?(cut-this.height):(cut+100);
    }
    @Override
    public BufferedImage getImage() {
        return column_type==PlayingPanel.TOP?Images.top_column:Images.bottom_column;
    }

    @Override
    public void step() {
        x-=step;
    }

}
