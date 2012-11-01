package vazkii.modmaker.tree.objective;

import java.util.TreeMap;

import vazkii.modmaker.gui.GuiCreateBranch;
import vazkii.modmaker.tree.TreeBranch;

import net.minecraft.src.GuiScreen;

public class AchievementsBranch extends TreeBranch {

	private String label;
	private TreeBranch superBranch;
	private TreeMap<String, TreeBranch> subBranches = new TreeMap();

	@Override
	public TreeBranch init(TreeBranch superBranch, String label) {
		this.label = label;
		this.superBranch = superBranch;
		return this;
	}

	@Override
	public TreeMap<String, TreeBranch> subBranches() {
		return subBranches;
	}

	@Override
	public TreeBranch superBranch() {
		return superBranch;
	}

	@Override
	public void addBranch(String branchName, TreeBranch branch) {
		if (branch instanceof AchievementBranch) subBranches.put(branchName, branch);
	}

	@Override
	public String label() {
		return label;
	}

	@Override
	public void deleteBranch(String branchName) {
		subBranches.remove(branchName);
	}

	@Override
	public GuiCreateBranch getBranchCreationGui(GuiScreen screen) {
		return new GuiCreateBranch(this, "Achievement", AchievementBranch.class, screen);
	}

}