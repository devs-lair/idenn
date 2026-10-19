package devs.lair.idenn.ui.componets;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class IdeSpliter extends JSplitPane {

    private static final int DIVIDER_DRAG_SIZE = 9;
    private static final int DIVIDER_DRAG_OFFSET = 4;

    public IdeSpliter(int orientation) {
        super(orientation);

        setDividerSize(1);
        setContinuousLayout(true);
    }

    @Override
    public void doLayout() {
        super.doLayout();

        // increase divider width or height
        BasicSplitPaneDivider divider = ((BasicSplitPaneUI) getUI()).getDivider();
        Rectangle bounds = divider.getBounds();
        if (orientation == HORIZONTAL_SPLIT) {
            bounds.x -= DIVIDER_DRAG_OFFSET;
            bounds.width = DIVIDER_DRAG_SIZE;
        } else {
            bounds.y -= DIVIDER_DRAG_OFFSET;
            bounds.height = DIVIDER_DRAG_SIZE ;
        }
        divider.setBounds(bounds);
    }

    @Override
    public void updateUI() {
        setUI(new SplitPaneWithZeroSizeDividerUI());
        revalidate();
    }

    private static class SplitPaneWithZeroSizeDividerUI extends BasicSplitPaneUI {
        @Override
        public BasicSplitPaneDivider createDefaultDivider() {
            return new ZeroSizeDivider(this);
        }
    }

    private static class ZeroSizeDivider extends BasicSplitPaneDivider {
        public ZeroSizeDivider( BasicSplitPaneUI ui ) {
            super( ui );
            super.setBorder( null );
            setBackground( UIManager.getColor( "controlShadow" ) );
        }

        @Override
        public void setBorder( Border border ) {
            // ignore
        }

        @Override
        public void paint( Graphics g ) {
            g.setColor( getBackground() );
            if( orientation == HORIZONTAL_SPLIT )
                g.drawLine( DIVIDER_DRAG_OFFSET, 0, DIVIDER_DRAG_OFFSET, getHeight() - 1 );
            else
                g.drawLine( 0, DIVIDER_DRAG_OFFSET, getWidth() - 1, DIVIDER_DRAG_OFFSET );
        }

        @Override
        protected void dragDividerTo( int location ) {
            super.dragDividerTo( location + DIVIDER_DRAG_OFFSET );
        }

        @Override
        protected void finishDraggingTo( int location ) {
            super.finishDraggingTo( location + DIVIDER_DRAG_OFFSET );
        }
    }
}
