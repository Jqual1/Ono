package uno.model;

public enum Cards {
    // WILDS (4 of each)
    WILD {
        @Override
        public String value() {
            return "WN";
        }
    }, WILD_DRAW {
        @Override
        public String value() {
            return "WD";
        }
    },
    // REDS (2 of each)
    RED_ONE {
        @Override
        public String value() {
            return "R1";
        }
    }, RED_TWO {
        @Override
        public String value() {
            return "R2";
        }
    }, RED_THREE {
        @Override
        public String value() {
            return "R3";
        }
    }, RED_FOUR {
        @Override
        public String value() {
            return "R4";
        }
    }, RED_FIVE {
        @Override
        public String value() {
            return "R5";
        }
    }, RED_SIX {
        @Override
        public String value() {
            return "R6";
        }
    }, RED_SEVEN {
        @Override
        public String value() {
            return "R7";
        }
    }, RED_EIGHT {
        @Override
        public String value() {
            return "R8";
        }
    }, RED_NINE {
        @Override
        public String value() {
            return "R9";
        }
    }, RED_REVERSE {
        @Override
        public String value() {
            return "RR";
        }
    }, RED_SKIP {
        @Override
        public String value() {
            return "RS";
        }
    }, RED_DRAW {
        @Override
        public String value() {
            return "RD";
        }
    },
    // BLUES (2 of each)
    BLUE_ONE {
        @Override
        public String value() {
            return "B1";
        }
    }, BLUE_TWO {
        @Override
        public String value() {
            return "B2";
        }
    }, BLUE_THREE {
        @Override
        public String value() {
            return "B3";
        }
    }, BLUE_FOUR {
        @Override
        public String value() {
            return "B4";
        }
    }, BLUE_FIVE {
        @Override
        public String value() {
            return "B5";
        }
    }, BLUE_SIX {
        @Override
        public String value() {
            return "B6";
        }
    }, BLUE_SEVEN {
        @Override
        public String value() {
            return "B7";
        }
    }, BLUE_EIGHT {
        @Override
        public String value() {
            return "B8";
        }
    }, BLUE_NINE {
        @Override
        public String value() {
            return "B9";
        }
    }, BLUE_REVERSE {
        @Override
        public String value() {
            return "BR";
        }
    }, BLUE_SKIP {
        @Override
        public String value() {
            return "BS";
        }
    }, BLUE_DRAW {
        @Override
        public String value() {
            return "BD";
        }
    },
    // YELLOWS (2 of each)
    YELLOW_ONE {
        @Override
        public String value() {
            return "Y1";
        }
    }, YELLOW_TWO {
        @Override
        public String value() {
            return "Y2";
        }
    }, YELLOW_THREE {
        @Override
        public String value() {
            return "Y3";
        }
    }, YELLOW_FOUR {
        @Override
        public String value() {
            return "Y4";
        }
    }, YELLOW_FIVE {
        @Override
        public String value() {
            return "Y5";
        }
    }, YELLOW_SIX {
        @Override
        public String value() {
            return "Y6";
        }
    }, YELLOW_SEVEN {
        @Override
        public String value() {
            return "Y7";
        }
    }, YELLOW_EIGHT {
        @Override
        public String value() {
            return "Y8";
        }
    }, YELLOW_NINE {
        @Override
        public String value() {
            return "Y9";
        }
    }, YELLOW_REVERSE {
        @Override
        public String value() {
            return "YR";
        }
    }, YELLOW_SKIP {
        @Override
        public String value() {
            return "YS";
        }
    }, YELLOW_DRAW {
        @Override
        public String value() {
            return "YD";
        }
    },
    // GREENS (2 of each)
    GREEN_ONE {
        @Override
        public String value() {
            return "G1";
        }
    }, GREEN_TWO {
        @Override
        public String value() {
            return "G2";
        }
    }, GREEN_THREE {
        @Override
        public String value() {
            return "G3";
        }
    }, GREEN_FOUR {
        @Override
        public String value() {
            return "G4";
        }
    }, GREEN_FIVE {
        @Override
        public String value() {
            return "G5";
        }
    }, GREEN_SIX {
        @Override
        public String value() {
            return "G6";
        }
    }, GREEN_SEVEN {
        @Override
        public String value() {
            return "G7";
        }
    }, GREEN_EIGHT {
        @Override
        public String value() {
            return "G8";
        }
    }, GREEN_NINE {
        @Override
        public String value() {
            return "G9";
        }
    }, GREEN_REVERSE {
        @Override
        public String value() {
            return "GR";
        }
    }, GREEN_SKIP {
        @Override
        public String value() {
            return "GS";
        }
    }, GREEN_DRAW {
        @Override
        public String value() {
            return "GD";
        }
    },
    // ZEROS (1 of each)
    RED_ZERO {
        @Override
        public String value() {
            return "R0";
        }
    },  BLUE_ZERO {
        @Override
        public String value() {
            return "B0";
        }
    },  YELLOW_ZERO {
        @Override
        public String value() {
            return "Y0";
        }
    },  GREEN_ZERO {
        @Override
        public String value() {
            return "G0";
        }
    },
    // WILDS (0 of each; for replacement of WILD/WILD_PLUS cards only)
    RED_WILD {
        @Override
        public String value() {
            return "RW";
        }
    }, BLUE_WILD {
        @Override
        public String value() {
            return "BW";
        }
    }, YELLOW_WILD {
        @Override
        public String value() {
            return "YW";
        }
    }, GREEN_WILD {
        @Override
        public String value() {
            return "GW";
        }
    };

    abstract public String value();
}
