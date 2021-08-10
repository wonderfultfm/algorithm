package com.tfm.algorithm.binarytree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: algorithm
 * @Package: com.tfm.algorithm.binarytree
 * @ClassName: TreeNode
 * @Author: tangfengmin
 * @Description: 树节点
 * @Date: 2021-7-1 18:02
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private int value;
    private TreeNode left;
    private TreeNode right;
}
