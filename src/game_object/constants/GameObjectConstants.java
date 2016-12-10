package game_object.constants;

import authoring.view.components.Component;
import game_object.GameObjectType;

public class GameObjectConstants {

    public static final String BLUE_SNAIL_LEFT = "img/sprites/blue_snail_left.png";
    public static final String BLUE_SNAIL_RIGHT = "img/sprites/blue_snail_right.png";
    public static final String ELIZA_LEFT = "img/sprites/eliza_left.png";
    public static final String ELIZA_RIGHT = "img/sprites/eliza_right.png";
    public static final String ORANGE_MUSHROOM_FILE = "img/sprites/orange_mushroom.png";
    public static final String RIBBON_PIG_FILE = "img/sprites/ribbon_pig.png";
    public static final String SLIME_FILE = "img/sprites/slime.png";
    public static final String STONE_BLOCK_FILE = "img/sprites/stone_block.png";
    public static final String BUSH_FILE = "img/sprites/bush.png";
    public static final String BRICK_FILE = "img/sprites/brick.png";
    // public static final String WEAPON_POWER_UP_FILE = "img/sprites/weapon_powerup.png";
    public static final String MARIO_GROUND_FILE = "img/sprites/mario_ground.png";
    public static final String BAR_FILE = "img/sprites/bar.png";
    public static final String BLACK_AND_GREY_FILE = "img/sprites/black_and_grey.png";
    public static final String BLACK_SQUARE_FILE = "img/sprites/black_square.png";
    public static final String BLUE_LIGHT_FILE = "img/sprites/blue_light.png";
    public static final String BLUE_METAL_FILE = "img/sprites/blue_metal.png";
    public static final String BOY_FILE = "img/sprites/boy.png";
    public static final String BOY2_FILE = "img/sprites/boy2.png";
    public static final String CAUTION_ORANGE_FILE = "img/sprites/caution_orange.png";
    public static final String CAUTION_ORANGE2_FILE = "img/sprites/caution_orange2.png";
    public static final String CAUTION_FILE = "img/sprites/caution.png";
    public static final String CINDERELLA_FILE = "img/sprites/cinderella.png";
    public static final String DIAGONAL_METAL_FILE = "img/sprites/diagonal_metal.png";
    public static final String DIAGONAL_WITH_BORDER_FILE = "img/sprites/diagonal_with_border.png";
    public static final String DIAGONAL_YELLOW_WITH_BORDER_FILE = "img/sprites/diagonal_yellow_with_border.png";
    public static final String DIAGONAL_FILE = "img/sprites/diagonal.png";
    public static final String DIAGONAL_YELLOW_FILE = "img/sprites/diagonal_yellow.png";
    public static final String FENCE_FILE = "img/sprites/fence.png";
    public static final String HALF_WHEEL_FILE = "img/sprites/half_wheel.png";
    public static final String METAL_BAR_FILE = "img/sprites/metal_bar.png";
    public static final String METAL_DIAGONAL_FILE = "img/sprites/metal_diagonal.png";
    public static final String METAL_FILE = "img/sprites/metal.png";
    public static final String SHORT_WAVY_FILE = "img/sprites/short_wavy.png";
    public static final String SPIKY_FILE = "img/sprites/spiky.png";
    public static final String STONE_SQUARE_FILE = "img/sprites/stone_square.png";
    public static final String WAVES_FILE = "img/sprites/waves.png";
    public static final String WAVY_GROUND_FILE = "img/sprites/wavy_ground.png";
    public static final String WHEEL_FILE = "img/sprites/wheel.png";
    public static final String GIRL_FILE = "img/sprites/xmasgirl1.png";
    public static final String YELLOW_LIGHT_FILE = "img/sprites/yellow_light.png";
    public static final String ORANGE_BULLET_FILE = "img/sprites/orange_bullet.png";
    public static final String GREEN_BULLET_FILE = "img/sprites/green_bullet.png";
    public static final String NEW_WEAPON_POWER_UP_FILE = "img/sprites/new_weapon_powerup.png";
    public static final String RED_GUN_WEAPON_RIGHT_FILE = "img/sprites/red_gun_right.png";
    public static final String RED_GUN_WEAPON_LEFT_FILE = "img/sprites/red_gun_left.png";
    public static final String BLUE_GUN_WEAPON_RIGHT_FILE = "img/sprites/blue_gun_right.png";
    public static final String BLUE_GUN_WEAPON_LEFT_FILE = "img/sprites/blue_gun_left.png";

    public static final Component BLUE_SNAIL = new Component(GameObjectType.HERO, BLUE_SNAIL_LEFT, BLUE_SNAIL_RIGHT, "Blue Snail", "A blue snail hero.");
    public static final Component ELIZA = new Component(GameObjectType.HERO, ELIZA_LEFT, ELIZA_RIGHT, "Eliza", "Eliza, a hero.");
    public static final Component ORANGE_MUSHROOM = new Component(GameObjectType.HERO, ORANGE_MUSHROOM_FILE, "Orange Mushroom", "An orange mushroom hero.");
    public static final Component RIBBON_PIG = new Component(GameObjectType.HERO, RIBBON_PIG_FILE, "Ribbon Pig", "A ribbon pig hero.");
    public static final Component SLIME = new Component(GameObjectType.HERO, SLIME_FILE, "Slime", "A slime hero.");
    public static final Component STONE_BLOCK = new Component(GameObjectType.STATIC_BLOCK, STONE_BLOCK_FILE, "Stone", "A stony block.");
    public static final Component BUSH = new Component(GameObjectType.STATIC_BLOCK, BUSH_FILE, "Bush", "A bush block.");
    public static final Component BRICK = new Component(GameObjectType.STATIC_BLOCK, BRICK_FILE, "Brick", "A brick block.");
    public static final Component NEW_WEAPON_POWER_UP = new Component(GameObjectType.WEAPON_POWER_UP, NEW_WEAPON_POWER_UP_FILE, "Weapon Power Up", "Power-up to acquire new weapon");
    public static final Component MARIO_GROUND = new Component(GameObjectType.STATIC_BLOCK, MARIO_GROUND_FILE, "Mario Ground", "the default ground in mario games");
    public static final Component BAR = new Component(GameObjectType.STATIC_BLOCK, BAR_FILE, "Bar Block", "a bar block.");
    public static final Component BLACK_AND_GREY = new Component(GameObjectType.STATIC_BLOCK, BLACK_AND_GREY_FILE, "Black and Grey Block", "a black and grey block.");
    public static final Component BLACK_SQUARE = new Component(GameObjectType.STATIC_BLOCK, BLACK_SQUARE_FILE, "Black Square Block", "a black and square block.");
    public static final Component BLUE_LIGHT = new Component(GameObjectType.STATIC_BLOCK, BLUE_LIGHT_FILE, "Blue Light Block", "a blue light block.");
    public static final Component BLUE_METAL = new Component(GameObjectType.STATIC_BLOCK, BLUE_METAL_FILE, "Blue Metal Block", "a blue metal block.");
    public static final Component BOY = new Component(GameObjectType.HERO, BOY_FILE, BOY_FILE, "Boy", "a boy avatar.");
    public static final Component BOY2 = new Component(GameObjectType.HERO, BOY2_FILE, BOY2_FILE, "Boy", "a boy avatar.");
    public static final Component CAUTION_ORANGE = new Component(GameObjectType.STATIC_BLOCK, CAUTION_ORANGE_FILE, "Caution Block", "a block with a caution tape design.");
    public static final Component CAUTION_ORANGE2 = new Component(GameObjectType.STATIC_BLOCK, CAUTION_ORANGE2_FILE, "Caution Block Version 2", "another block with a caution tape design.");
    public static final Component CAUTION = new Component(GameObjectType.STATIC_BLOCK, CAUTION_FILE, "Caution Block", "a yellow block with a caution tape design.");
    public static final Component CINDERELLA = new Component(GameObjectType.HERO, CINDERELLA_FILE, CINDERELLA_FILE, "Cinderella", "a cinderella avatar.");
//    public static final Component DIAGONAL_METAL = new Component(GameObjectType.STATIC_BLOCK, DIAGONAL_METAL_FILE, "Diagonal Metal Block", "a metal block with diagonal design.");
//    public static final Component DIAGONAL_WITH_BORDER =  new Component(GameObjectType.STATIC_BLOCK, DIAGONAL_WITH_BORDER_FILE, "Diagonal Metal Block with Border", "a metal block with diagonal design, with a thick border.");
//    public static final Component DIAGONAL_YELLOW_WITH_BORDER =  new Component(GameObjectType.STATIC_BLOCK, DIAGONAL_YELLOW_WITH_BORDER_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component DIAGONAL = new Component(GameObjectType.STATIC_BLOCK, DIAGONAL_FILE, "Diagonal Metal Block", "a metal block .");
//    public static final Component DIAGONAL_YELLOW = new Component(GameObjectType.STATIC_BLOCK, DIAGONAL_YELLOW_WITH_BORDER_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component FENCE = new Component(GameObjectType.STATIC_BLOCK, FENCE_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component HALF_WHEEL = new Component(GameObjectType.STATIC_BLOCK, HALF_WHEEL_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component METAL_BAR = new Component(GameObjectType.STATIC_BLOCK, METAL_BAR_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component METAL_DIAGONAL = new Component(GameObjectType.STATIC_BLOCK, METAL_DIAGONAL_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component METAL = new Component(GameObjectType.STATIC_BLOCK, METAL_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component SHORT_WAVY = new Component(GameObjectType.STATIC_BLOCK, SHORT_WAVY_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component SPIKY = new Component(GameObjectType.STATIC_BLOCK, SPIKY_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component STONE_SQUARE = new Component(GameObjectType.STATIC_BLOCK, STONE_SQUARE_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component WAVES = new Component(GameObjectType.STATIC_BLOCK, WAVES_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component WAVY_GROUND = new Component(GameObjectType.STATIC_BLOCK, WAVY_GROUND_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component WHEEL = new Component(GameObjectType.STATIC_BLOCK, WHEEL_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component GIRl = new Component(GameObjectType.HERO, GIRL_FILE, GIRL_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    public static final Component YELLOW_LIGHT = new Component(GameObjectType.STATIC_BLOCK, YELLOW_LIGHT_FILE, "Diagonal Metal Block", "a metal block with yellow diagonal design.");
//    
    public static final String UPLOAD = "img/upload.png";
}
