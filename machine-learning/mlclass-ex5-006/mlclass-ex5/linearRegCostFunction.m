function [J, grad] = linearRegCostFunction(X, y, theta, lambda)
%LINEARREGCOSTFUNCTION Compute cost and gradient for regularized linear 
%regression with multiple variables
%   [J, grad] = LINEARREGCOSTFUNCTION(X, y, theta, lambda) computes the 
%   cost of using theta as the parameter for linear regression to fit the 
%   data points in X and y. Returns the cost in J and the gradient in grad

% Initialize some useful values
m = length(y); % number of training examples
grad = zeros(size(theta));

% Temporal calculus 
error_matrix = X * theta - y;
theta_temp = theta;
theta_temp(1) = 0;

% Cost
J = 1 / (2 * m) * (sumsq(error_matrix) + lambda * sumsq(theta_temp));

% Gradient
grad = 1 / m * ((error_matrix' * X)' + lambda * theta_temp);

grad = grad(:);

end
