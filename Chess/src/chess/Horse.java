package chess;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

public class Horse extends Piece {

	public Horse(Dimension dim, TYPE type, SIDE side) {
		super(dim, type, side);
		if (this.side == SIDE.white) {
			this.setPath("src/50px-Chess_nlt45.svg.png");
		} else if (this.side == SIDE.black) {
			this.setPath("src/50px-Chess_ndt45.svg.png");
		}
	}

	@Override
	public boolean checkIfValidPath(int finalX, int finalY, ArrayList<Piece> pieces) {
		boolean check = false;
		if (this.getX() + 1 == finalX || this.getX() - 1 == finalX) {
			if (this.getY() + 2 == finalY) {
				check = true;
				for (Piece temp : pieces) {
					if (temp.getDim().equals(new Dimension(finalX, finalY)) && temp.getSide().equals(this.getSide())) {
						check = false;
						break;
					}
				}
			} else if (this.getY() - 2 == finalY) {
				check = true;
				for (Piece temp : pieces) {
					if (temp.getDim().equals(new Dimension(finalX, finalY)) && temp.getSide().equals(this.getSide())) {
						check = false;
						break;
					}
				}
			}
		} else if (this.getX() + 2 == finalX || this.getX() - 2 == finalX) {
			if (this.getY() + 1 == finalY) {
				check = true;
				for (Piece temp : pieces) {
					if (temp.getDim().equals(new Dimension(finalX, finalY)) && temp.getSide().equals(this.getSide())) {
						check = false;
						break;
					}
				}
			} else if (this.getY() - 1 == finalY) {
				check = true;
				for (Piece temp : pieces) {
					if (temp.getDim().equals(new Dimension(finalX, finalY)) && temp.getSide().equals(this.getSide())) {
						check = false;
						break;
					}
				}
			}
		}
		return check;
	}

	@Override
	public void drawPossiblePath(ArrayList<Piece> pieces, Graphics g) {int i = 0;

	while (i < 8) {
		for (int j = 0; j < 8; j++) {
			if (this.checkIfValidPath(i, j, pieces)) {
				if (this.getSide().equals(SIDE.white))
					g.drawImage(this.getIm("src/skyBall.png"), i * 80, j * 80, 80, 80,
							null);
				else if (this.getSide().equals(SIDE.black))
					g.drawImage(this.getIm("src/lightning.png"), i * 80, j * 80, 80, 80,
							null);
			}

		}
		i++;
	}
}

	@Override
	public ArrayList<Dimension> getPossiblePath(ArrayList<Piece> pieces) {
		ArrayList<Dimension> dims = new ArrayList<>();
		int i = 0;
		while (i < 8) {
			for (int j = 0; j < 8; j++) {
				if (this.checkIfValidPath(i, j, pieces))
					dims.add(new Dimension(i, j));
			}
			i++;
		}

		return dims;
	}

	@Override
	public boolean checkIfKingEndangered(ArrayList<Piece> pieces) {
		// TODO Auto-generated method stub
		return false;
	}

}
